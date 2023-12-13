interface Visitor {
    void visit(MyFile file);

    void visit(MyDirectory directory);
}