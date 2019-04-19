package edu.nju.antiTerroristFinancialBehavior.model;

/**
 * 一级指标
 *
 * @author fanleehao on 2019/4/19
 *
 * CREATE TABLE `first_index` (
 *   `id` bigint(20) NOT NULL AUTO_INCREMENT,
 *   `index_name` varchar(255) NOT NULL COMMENT '一级指标名',
 *   `desc` varchar(255) DEFAULT NULL COMMENT '描述',
 *   `weight_num` int(11) NOT NULL DEFAULT '1' COMMENT '权重分子',
 *   `weight_deno` int(11) NOT NULL DEFAULT '1' COMMENT '权重分母',
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8
 */

public class FirstIndex {
    private Integer id;
    private String index_name;
    private String desc;
    private Integer weight_num;
    private Integer weight_deno;

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

    @Override
    public String toString() {
        return "FirstIndex{" +
                "id=" + id +
                ", index_name='" + index_name + '\'' +
                ", desc='" + desc + '\'' +
                ", weight_num=" + weight_num +
                ", weight_deno=" + weight_deno +
                '}';
    }
}
