package cn.team.mapper;

import cn.team.entity.Picture;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PictureMapper {
    @Delete({
            "delete from picture",
            "where pic_id = #{picId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer picId);

    @Insert({
            "insert into picture (pic_id, pic_name, ",
            "pic_url, pic_intro)",
            "values (#{picId,jdbcType=INTEGER}, #{picName,jdbcType=VARCHAR}, ",
            "#{picUrl,jdbcType=VARCHAR}, #{picIntro,jdbcType=LONGVARCHAR})"
    })
    int insert(Picture record);

    @InsertProvider(type = PictureSqlProvider.class, method = "insertSelective")
    int insertSelective(Picture record);

    @Select({
            "select",
            "pic_id, pic_name, pic_url, pic_intro",
            "from picture",
            "where pic_id = #{picId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "pic_id", property = "picId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "pic_name", property = "picName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pic_url", property = "picUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pic_intro", property = "picIntro", jdbcType = JdbcType.LONGVARCHAR)
    })
    Picture selectByPrimaryKey(Integer picId);

    @UpdateProvider(type = PictureSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Picture record);

    @Update({
            "update picture",
            "set pic_name = #{picName,jdbcType=VARCHAR},",
            "pic_url = #{picUrl,jdbcType=VARCHAR},",
            "pic_intro = #{picIntro,jdbcType=LONGVARCHAR}",
            "where pic_id = #{picId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Picture record);

    @Update({
            "update picture",
            "set pic_name = #{picName,jdbcType=VARCHAR},",
            "pic_url = #{picUrl,jdbcType=VARCHAR}",
            "where pic_id = #{picId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Picture record);
}