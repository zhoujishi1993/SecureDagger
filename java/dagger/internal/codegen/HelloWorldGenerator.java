package dagger.internal.codegen;

import com.google.auto.value.AutoAnnotation;
import com.google.common.base.Joiner;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import java.util.Optional;

import static com.squareup.javapoet.MethodSpec.constructorBuilder;
import static com.squareup.javapoet.MethodSpec.methodBuilder;
import static com.squareup.javapoet.TypeSpec.classBuilder;
import static javax.lang.model.element.Modifier.*;

public class HelloWorldGenerator extends SourceFileGenerator<TypeElement> {

    String s = "Hello world";

    public HelloWorldGenerator(Filer filer, Elements elements, String s) {
        super(filer, elements);
        this.s = s;
    }

    @Override
    ClassName nameGeneratedType(TypeElement input) {
        ClassName componentDefinitionClassName = ClassName.get(input);
        String componentName =
                "Dagger_HelloWorld";
        return componentDefinitionClassName.topLevelClassName().peerClass(componentName);
    }

    @Override
    Optional<? extends Element> getElementForErrorReporting(TypeElement input) {
        return Optional.of(input);
    }

    @Override
    Optional<TypeSpec.Builder> write(ClassName generatedTypeName, TypeElement input) {
        TypeSpec.Builder annotationCreatorBuilder =
                classBuilder(generatedTypeName)
                        .addModifiers(PUBLIC, FINAL)
                        .addMethod(constructorBuilder().addModifiers(PRIVATE).build());
        annotationCreatorBuilder.addMethod(buildCreateMethod());

        return Optional.of(annotationCreatorBuilder);
    }

    MethodSpec buildCreateMethod(){
        MethodSpec.Builder createMethod =
                methodBuilder("HelloWold")
                        .addModifiers(PUBLIC, STATIC)
                        .returns(TypeName.VOID);
//        createMethod.addCode();
        return createMethod.build();
    }
}
