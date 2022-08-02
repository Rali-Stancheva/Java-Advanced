package ADVANCED.EXAMS.EXAM_22_Feb_2020.guild;

public class Player {
    private String name;
    private String clazz;
    private String rank;
    private String description;

    public Player(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
        this.rank = "Trial";
        this.description = "n/a";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Player %s: %s",this.name,this.clazz)).append("\n");
        builder.append(String.format("Rank: %s",this.rank)).append("\n");
        builder.append(String.format("Description: %s",this.description));

        return builder.toString();
    }


}
