package ru.mirea.lab6.Builder;

class ConcreteBuilder implements Builder {
    private Product product = new Product();

    @Override
    public void buildPart1() {
        product.setPart1("Part 1");
    }

    @Override
    public void buildPart2() {
        product.setPart2("Part 2");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
