import java.util.ArrayList;
import java.util.List;

public final class CodeBlock {
    private CodeBlock(Builder builder) {

    }

    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder {
        final List<String> formatParts = new ArrayList<>();
        final List<Object> args = new ArrayList<>();
        private Builder(){

        }

        public Builder add(String format, Object... object) {
            return this;
        }

        public Builder beginControlFlow(String controlFlow, Object... object){
            return this;
        }

        public CodeBlock build(){
            return new CodeBlock(this);
        }
    }
}