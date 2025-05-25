package model;

public class Vote {
    private int id;
    private int voterId;
    private String candidate;

    // Constructors
    public Vote() {}
    public Vote(int voterId, String candidate) {
        this.voterId = voterId;
        this.candidate = candidate;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getVoterId() {
        return voterId;
    }
    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }
    public String getCandidate() {
        return candidate;
    }
    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }
}
