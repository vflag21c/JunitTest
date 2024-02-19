package org.example.junittest.acrhunittest;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

public class OnionArchitecture {


    /**
     * 다양한 아키텍처 검증이 가능하다.
     * 참고 : https://www.archunit.org/userguide/html/000_Index.html#_architectures
     */


    //어니언(헥사고날) 아키텍처 검증.
    @Test
    void 헥사고날_아키텍처_검증(){
        JavaClasses classes = new ClassFileImporter().importPackages("com.tngtech.archunit.example.onionarchitecture");

        onionArchitecture()
                .domainModels("com.myapp.domain.model..")
                .domainServices("com.myapp.domain.service..")
                .applicationServices("com.myapp.application..")
                .adapter("cli", "com.myapp.adapter.cli..")
                .adapter("persistence", "com.myapp.adapter.persistence..")
                .adapter("rest", "com.myapp.adapter.rest..")
                .check(classes);
    }
}
