package org.example.junittest.acrhunittest;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

public class ArchunitTest {

    @Test
    void arch_unit_test(){

        JavaClasses classes = new ClassFileImporter().importPackages("org.example");

        /**
         * 1. ..domain.. 패키지에 있는 클래스는 ..study.., ..member.., ..domain에서 참조 가능.
         * 2. ..domain.. 패키지는 ..member.. 패키지를 참조하지 못한다.
         * 3. ..study.. 패키지에 있는 클래스는 ..study.. 에서만 참조 가능.
         * 4. 순환 참조 없어야 한다.
         */

        //1.
        ArchRule domainPackageRule = classes().that().resideInAnyPackage("..domain..")
                .should().onlyBeAccessed().byClassesThat()
                .resideInAnyPackage("..study..", "..member..", "..domain..");
        domainPackageRule.check(classes);

        //2.
        ArchRule memberPackageRule = noClasses().that().resideInAnyPackage("..domain..")
                .should().accessClassesThat().resideInAnyPackage("..member..");
        memberPackageRule.check(classes);

        //3.
        ArchRule studyPackageRule = noClasses().that().resideOutsideOfPackage("..study..")
                .should().accessClassesThat().resideInAPackage("..study..");
        studyPackageRule.check(classes);

        //4.
        ArchRule freeOfCycles = slices().matching("..org.example.(*)..")
                .should().beFreeOfCycles();
        freeOfCycles.check(classes);

    }
}
