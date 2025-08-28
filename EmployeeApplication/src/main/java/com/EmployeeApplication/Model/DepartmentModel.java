package com.EmployeeApplication.Model;

public class DepartmentModel {
    private int deptId;
    private String deptName;

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public DepartmentModel(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }
}
