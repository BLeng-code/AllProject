import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic.Kind;

public class MyProcessor extends AbstractProcessor {
    private Filer filer;
    private Types typeUtils;
    private Elements elementUtils;
    private Messager messager;

    @Override
    public synchronized void init(final ProcessingEnvironment processingEnv) {
        // TODO Auto-generated method stub
        super.init(processingEnv);
        filer = processingEnv.getFiler();
        typeUtils = processingEnv.getTypeUtils();
        elementUtils = processingEnv.getElementUtils();
        messager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // TODO Auto-generated method stub
        final Set<Element> elements = (Set<Element>) roundEnv.getElementsAnnotatedWith(SingleInstance.class);
        for (final Element element : elements) {
            if (element instanceof TypeElement) {
                final TypeElement typeElement = (TypeElement) element;
                final PackageElement packageElement = elementUtils.getPackageOf(typeElement);
                final String className = typeElement.getSimpleName().toString();
                final FieldSpec fieldSpec = FieldSpec
                        .builder(TypeVariableName.get(className), "instance").addModifiers(Modifier.STATIC, Modifier.PRIVATE).build();
                final CodeBlock codeBlock = CodeBlock.builder().addStatement("instance = new $L()", className).build();
                final MethodSpec methodSpec = MethodSpec.methodBuilder("getInstance")
                        .returns(TypeVariableName.get(className)).addModifiers(Modifier.PUBLIC)
                        .addStatement("return instance").build();
                final TypeSpec typeSpec = TypeSpec.classBuilder(className).addMethod(methodSpec).addField(fieldSpec)
                        .addStaticBlock(codeBlock)        
                        .build();
                final JavaFile javaFile = JavaFile.builder(packageElement.getQualifiedName().toString(), typeSpec)
                        .build();
                try {
                    javaFile.writeTo(filer);
                } catch (final Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            } else {
                messager.printMessage(Kind.ERROR, "SingleInstance Just can be used above type");
            }
        }
        return false;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        // TODO Auto-generated method stub
        final Set<String> annotations = new LinkedHashSet<>();
        annotations.add(SingleInstance.class.getCanonicalName());
        return annotations;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        // TODO Auto-generated method stub
        return SourceVersion.latestSupported();
    }
}