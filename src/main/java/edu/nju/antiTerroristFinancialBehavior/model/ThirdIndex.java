package edu.nju.antiTerroristFinancialBehavior.model;

/**
 * 三级指标
 *
 * @author fanleehao on 2019/4/19
 *
 * CREATE TABLE `third_index` (
 *   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '三级指标',
 *   `index_name` varchar(255) NOT NULL COMMENT '三级指标名称',
 *   `desc` varchar(255) DEFAULT NULL COMMENT '描述',
 *   `weight_num` int(11) NOT NULL DEFAULT '1' COMMENT '权重分子',
 *   `weight_deno` int(11) NOT NULL DEFAULT '1' COMMENT '权重分母',
 *   `type` varchar(255) DEFAULT NULL COMMENT '指标类型，离散或连续',
 *   `normalize` varchar(255) DEFAULT NULL COMMENT '量化标准',
 *   `source` varchar(255) DEFAULT NULL COMMENT '指标来源',
 *   `first_index` bigint(20) NOT NULL COMMENT '所属一级指标',
 *   `second_index` bigint(20) NOT NULL COMMENT '所属二级指标',
 *   PRIMARY KEY (`id`),
 *   KEY `third_first_ref` (`first_index`),
 *   KEY `third_second_ref` (`second_index`),
 *   CONSTRAINT `third_first_ref` FOREIGN KEY (`first_index`) REFERENCES `first_index` (`id`),
 *   CONSTRAINT `third_second_ref` FOREIGN KEY (`second_index`) REFERENCES `second_index` (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8
 */
public class ThirdIndex {

    private Integer id;
    private String index_name;
    private String desc;
    private Integer weight_num;
    private Integer weight_deno;
    private String type;
    private String normalize;
    private String source;
    //所属一二级指标
    private FirstIndex first_index;
    private SecondIndex second_index;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNormalize() {
        return normalize;
    }

    public void setNormalize(String normalize) {
        this.normalize = normalize;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public FirstIndex getFirst_index() {
        return first_index;
    }

    public void setFirst_index(FirstIndex first_index) {
        this.first_index = first_index;
    }

    public SecondIndex getSecond_index() {
        return second_index;
    }

    public void setSecond_index(SecondIndex second_index) {
        this.second_index = second_index;
    }
}
