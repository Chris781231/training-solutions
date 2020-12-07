package statemachine.typewriter;

public enum TypeWriterState implements HasChangeableTypeWriterState {
    UPPERCASE {
        @Override
        public TypeWriterState next() {
            return TypeWriterState.LOWERCASE;
        }
    },
    LOWERCASE {
        @Override
        public TypeWriterState next() {
            return TypeWriterState.UPPERCASE;
        }
    }
}
