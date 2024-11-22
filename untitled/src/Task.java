public class Task {
    private String name;       //Describing what the task consists in. It will always include an abbreviation for the subject it’s associated to (for instance, APDS).
    private String limit;      //Date indicating the task’s deadline, following the d-M-yy format (day, month, and the last two digits of the year).
    private int time;          //Integer giving an approximation, in minutes, of the time it would take to complete this task from scratch.
    private int difficulty;    //Integer in the [1, 10] range indicating how hard the task is (1: very easy, 10: very hard).
    private int progress;      //Integer in the [0, 100] range showing the current progress percentage for the task (0: yet to be started, 100: fully completed).
    private String importance; //String representing the task’s level of importance as a colour in the RGB scale by using hexadecimal code (for instance, #E43400).
    private String building;   //String containing the acronym of the building where the task must be carried out in.


    public Task (String name, String limit, int time, int difficulty, int progress, String importance, String building) {
        this.name = name;
        this.limit = limit;
        this.time = time;
        this.difficulty = difficulty;
        this.progress = progress;
        this.importance = importance;
        this.building = building;


    }
    public int priorityFormula() {
        return (int) (progress * 0.3 + difficulty * 0.4 + time * 0.20);
    }
    public String getName() {
        return name;
    }
    public String getLimit() {
        return limit;
    }
    public int getTime() {
        return time;
    }
    public int getDifficulty() {
        return difficulty;
    }
    public int getProgress() {
        return progress;
    }
    public String getImportance() {
        return importance;
    }
    public String getBuilding() {
        return building;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setLimit(String limit) {
        this.limit = limit;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
    public void setProgress(int progress) {
        this.progress = progress;
    }
    public void setImportance(String importance) {
        this.importance = importance;
    }
    public void setBuilding(String building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", limit='" + limit + '\'' +
                ", time=" + time +
                ", difficulty=" + difficulty +
                ", progress=" + progress +
                ", importance='" + importance + '\'' +
                ", building='" + building + '\'' +
                '}';
    }

}

