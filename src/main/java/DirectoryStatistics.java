class DirectoryStatistics implements Visitor {
    private int fileCount = 0;
    private long totalSize = 0;

    public int getFileCount() {
        return fileCount;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void reset() {
        fileCount = 0;
        totalSize = 0;
    }

    // Метод для обновления статистики по директории
    public void updateStatistics(MyDirectory rootDirectory) {
        rootDirectory.accept(this);
    }

    @Override
    public void visit(MyFile file) {
        fileCount++;
        totalSize += file.getSize();
    }

    @Override
    public void visit(MyDirectory directory) {

    }
}
