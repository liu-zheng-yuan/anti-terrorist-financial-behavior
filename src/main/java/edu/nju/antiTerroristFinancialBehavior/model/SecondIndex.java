package edu.nju.antiTerroristFinancialBehavior.model;

/**
 * 二级指标
 *
 * @author fanleehao on 2019/4/19
 *
 * CREATE TABLE `second_index` (
 *   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '二级指标',
 *   `index_name` varchar(255) NOT NULL COMMENT '二级指标名',
 *   `desc` varchar(255) DEFAULT NULL COMMENT '二级指标描述',
 *   `weight_num` int(11) NOT NULL DEFAULT '1' COMMENT '权重分子',
 *   `weight_deno` int(11) NOT NULL DEFAULT '1' COMMENT '权重分母',
 *   `first_index` bigint(20) NOT NULL COMMENT '所属一级指标',
 *   PRIMARY KEY (`id`),
 *   KEY `index-ref` (`first_index`),
 *   CONSTRAINT `index-ref` FOREIGN KEY (`first_index`) REFERENCES `first_index` (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8
 */
public class SecondIndex {
    private Integer id;
    private String index_name;
    private String desc;
    private Integer weight_num;
    private Integer weight_deno;

    //所属一级指标
    private FirstIndex first_index;

    //树形菜单表ID
    private Integer menuID;

    public Integer getMenuID() {
        return menuID;
    }

    public void setMenuID(Integer menuID) {
        this.menuID = menuID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndex_name() {
        return index_name;
    }

    public void setIndex_name(String index_name) {
        this.index_name = index_name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getWeight_num() {
        return weight_num;
    }

    public void setWeight_num(Integer weight_num) {
        this.weight_num = weight_num;
    }

    public Integer getWeight_deno() {
        return weight_deno;
    }

    public void setWeight_deno(Integer weight_deno) {
        this.weight_deno = weight_deno;
    }

    public FirstIndex getFirst_index() {
        return first_index;
    }

    public void setFirst_index(FirstIndex first_index) {
        this.first_index = first_index;
    }
}
