package com.example.immaculate.mygym;

public class WorkoutInformation {
    public String workoutDay,gymLocation,workoutType,RepNp,SetNo;

    public WorkoutInformation(String workoutDay, String gymLocation, String wokoutType, String repNp, String setNo) {
        this.workoutDay = workoutDay;
        this.gymLocation = gymLocation;
        this.workoutType = wokoutType;
        RepNp = repNp;
        SetNo = setNo;
    }

    public String getWorkoutDay() {
        return workoutDay;
    }

    public void setWorkoutDay(String workoutDay) {
        this.workoutDay = workoutDay;
    }

    public String getGymLocation() {
        return gymLocation;
    }

    public void setGymLocation(String gymLocation) {
        this.gymLocation = gymLocation;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }

    public String getRepNp() {
        return RepNp;
    }

    public void setRepNp(String repNp) {
        RepNp = repNp;
    }

    public String getSetNo() {
        return SetNo;
    }

    public void setSetNo(String setNo) {
        SetNo = setNo;
    }
}
