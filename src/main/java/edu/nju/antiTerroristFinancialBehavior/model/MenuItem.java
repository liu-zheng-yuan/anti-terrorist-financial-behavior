package edu.nju.antiTerroristFinancialBehavior.model;

/**
 * 菜单项对象，根据指标来
 * @author fanleehao on 2019/4/19
 * {"accessPath":"","checked":false,"delFlag":0,"parentID":1,"resourceCode":"","resourceDesc":"",
 * "resourceGrade":2,"resourceID":2,"resourceName":"流水交易情况","resourceOrder":0,"resourceType":""},
 */
public class MenuItem {

    private String accessPath;
    private Boolean checked;
    private Integer delFlag;
    private Integer parentID;
    private String resourceCode;
    private String resourceDesc;
    private Integer resourceGrade;
    private Integer resourceID;
    private String resourceName;
    private Integer resourceOrder;
    private String resourceType;

    public String getAccessPath() {
        return accessPath;
    }

    public void setAccessPath(String accessPath) {
        this.accessPath = accessPath;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getParentID() {
        return parentID;
    }

    public void setParentID(Integer parentID) {
        this.parentID = parentID;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }

    public Integer getResourceGrade() {
        return resourceGrade;
    }

    public void setResourceGrade(Integer resourceGrade) {
        this.resourceGrade = resourceGrade;
    }

    public Integer getResourceID() {
        return resourceID;
    }

    public void setResourceID(Integer resourceID) {
        this.resourceID = resourceID;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Integer getResourceOrder() {
        return resourceOrder;
    }

    public void setResourceOrder(Integer resourceOrder) {
        this.resourceOrder = resourceOrder;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public MenuItem(){}

    public MenuItem(String accessPath, Boolean checked, Integer delFlag, Integer parentID, String resourceCode, String resourceDesc, Integer resourceGrade, Integer resourceID, String resourceName, Integer resourceOrder, String resourceType) {
        this.accessPath = accessPath;
        this.checked = checked;
        this.delFlag = delFlag;
        this.parentID = parentID;
        this.resourceCode = resourceCode;
        this.resourceDesc = resourceDesc;
        this.resourceGrade = resourceGrade;
        this.resourceID = resourceID;
        this.resourceName = resourceName;
        this.resourceOrder = resourceOrder;
        this.resourceType = resourceType;
    }
}
