/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package castracker;

/**
 *
 * @author SangHooLeeINtern
 */
public class StoreData {
    private String date;
    private String projectName;
    private String cas;
    private String objective;
    private int time;
    private String reflection;
    public StoreData(){
        date = null;
        projectName = null;
        cas = null;
        objective = null;
        time = 0;
        reflection = null;
    }
    public void setDate(String Date)    {
        date = Date;
    }
    public void setProjectName(String ProjectName)  {
        projectName = ProjectName;
    }
    public void setCAS(String CAS)  {
        cas = CAS;
    }
    public void setobjective(String Objective)  {
        objective = Objective;
    }
    public void setTime(int Time)   {
        time = Time;
    }
    public void setReflection(String Reflection)    {
        reflection = Reflection;
    }
    @Override
    public String toString()    {
        return date + " " + projectName + " " + cas +
                " " + objective + " " + time + " " + reflection + "\n";
    }
}
