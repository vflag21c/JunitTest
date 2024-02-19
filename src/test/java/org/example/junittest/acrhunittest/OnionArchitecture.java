package org.example.junittest.acrhunittest;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

public class OnionArchitecture {


    /**
     * 다양한 아키텍처 검증이 가능하다.
     * 참고 : https://www.archunit.org/userguide/html/000_Index.html#_architectures
     *     : https://d2.naver.com/helloworld/9222129 ( 네이버 정산프로세스 개발자 )
     * example source : https://github.com/TNG/ArchUnit-Examples/blob/main/example-plain/src/test/java/com/tngtech/archunit/exampletest/OnionArchitectureTest.java
     */

    /**
     *  - 패키지 의존성 체크
     *  - 클래스 의존성 체크
     *  - 패키지 네이밍 룰 체크
     *  - 구현체 네이밍 룰 체크
     *  - 구현체 어노테이션 체크
     *  - 레이어 체크
     *  - 순환구조 체크
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
