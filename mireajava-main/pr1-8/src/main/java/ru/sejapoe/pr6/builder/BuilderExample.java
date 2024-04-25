package ru.sejapoe.pr6.builder;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
class Product {
    private String name;
    private int amount;
}

interface Builder {
    Builder name(String name);
    Builder amount(int amount);
    Product build();
}

class ConcreteBuilder implements Builder {
    private final Product product = new Product();

    @Override
    public Builder name(String name) {
        product.setName(name);
        return this;
    }

    @Override
    public Builder amount(int amount) {
        product.setAmount(amount);
        return this;
    }

    @Override
    public Product build() {
        return product;
    }
}
public class BuilderExample {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Product product = builder
                .name("x")
                .amount(100)
                .build();
        System.out.println(product);
    }
}
