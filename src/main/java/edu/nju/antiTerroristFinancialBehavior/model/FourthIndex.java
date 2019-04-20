package edu.nju.antiTerroristFinancialBehavior.model;

/**
 * 四级指标（最细粒度）
 *
 * @author fanleehao on 2019/4/20
 *
 * CREATE TABLE `tb_fourth_index` (
 *   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '四级指标',
 *   `index_name` varchar(255) NOT NULL COMMENT '四级指标名称',
 *   `desc` varchar(255) DEFAULT NULL COMMENT '描述',
 *   `weight_num` int(11) NOT NULL DEFAULT '1' COMMENT '权重分子',
 *   `weight_deno` int(11) NOT NULL DEFAULT '1' COMMENT '权重分母',
 *   `dimension` varchar(255) DEFAULT NULL COMMENT '维度',
 *   `type` varchar(255) DEFAULT NULL COMMENT '指标类型,离散,连续',
 *   `range` varchar(255) DEFAULT NULL COMMENT '范围',
 *   `normalize` varchar(255) DEFAULT NULL COMMENT '量化标准(计算方法)',
 *   `first_index` bigint(20) NOT NULL COMMENT '所属一级指标',
 *   `second_index` bigint(20) NOT NULL COMMENT '所属二级指标',
 *   `third_index` bigint(20) NOT NULL COMMENT '所属三级指标',
 *   PRIMARY KEY (`id`),
 *   KEY `fourth_first_ref` (`first_index`),
 *   KEY `fourth_second_ref` (`second_index`),
 *   KEY `fourth_third_ref` (`third_index`),
 *   CONSTRAINT `fourth_first_ref` FOREIGN KEY (`first_index`) REFERENCES `tb_first_index` (`id`),
 *   CONSTRAINT `fourth_second_ref` FOREIGN KEY (`second_index`) REFERENCES `tb_second_index` (`id`),
 *   CONSTRAINT `fourth_third_ref` FOREIGN KEY (`third_index`) REFERENCES `tb_third_index` (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=194 DEFAULT CHARSET=utf8
 */

public class FourthIndex {

    private Integer id;
    private String index_name;
    private String desc;
    private Integer weight_num;
    private Integer weight_deno;
    private String dimension;
    private String type;
    private String range;
    private String normalize;

    private FirstIndex firstIndex;
    private SecondIndex secondIndex;
    private ThirdIndex thirdIndex;

    //树形菜单表ID
    private Integer menuID;

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

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getNormalize() {
        return normalize;
    }

    public void setNormalize(String normalize) {
        this.normalize = normalize;
    }

    public FirstIndex getFirstIndex() {
        return firstIndex;
    }

    public void setFirstIndex(FirstIndex firstIndex) {
        this.firstIndex = firstIndex;
    }

    public SecondIndex getSecondIndex() {
        return secondIndex;
    }

    public void setSecondIndex(SecondIndex secondIndex) {
        this.secondIndex = secondIndex;
    }

    public ThirdIndex getThirdIndex() {
        return thirdIndex;
    }

    public void setThirdIndex(ThirdIndex thirdIndex) {
        this.thirdIndex = thirdIndex;
    }

    public Integer getMenuID() {
        return menuID;
    }

    public void setMenuID(Integer menuID) {
        this.menuID = menuID;
    }

    @Override
    public String toString() {
        return "FourthIndex{" +
                "id=" + id +
                ", index_name='" + index_name + '\'' +
                ", desc='" + desc + '\'' +
                ", weight_num=" + weight_num +
                ", weight_deno=" + weight_deno +
                ", dimension='" + dimension + '\'' +
                ", type='" + type + '\'' +
                ", range='" + range + '\'' +
                ", normalize='" + normalize + '\'' +
                ", menuID=" + menuID +
                '}';
    }
}
