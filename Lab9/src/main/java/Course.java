class Course {
    private int minimum;
    private int maximum;
    private Course prerequisite;

    public Course(int minimum, int maximum, Course prerequisite) {
        this.minimum = minimum;
        this.maximum = maximum;
        this.prerequisite = prerequisite;
    }

    public int getMinimum() {
        return minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public Course getPrerequisite() {
        return prerequisite;
    }
}