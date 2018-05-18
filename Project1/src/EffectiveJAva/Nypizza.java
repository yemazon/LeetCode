package EffectiveJAva;

import java.util.Objects;

public class Nypizza extends Pizza {
    public enum Size {SMALL, MEDIUM, LARGE}
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override public Nypizza build() {
            return new Nypizza(this);
        }

        @Override protected Builder self() {
            return this;
        }
    }

    private Nypizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}
