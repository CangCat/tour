package cn.team.mapper;

import cn.team.entity.Hotel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface HotelMapper {
    @Delete({
            "delete from hotel",
            "where hotel_id = #{hotelId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer hotelId);

    @Insert({
            "insert into hotel (hotel_id, scenic_id, ",
            "hotel_class, hotel_name, ",
            "hotel_link, hotel_tel, ",
            "hotel_address, hotel_pic, ",
            "status, creat_time)",
            "values (#{hotelId,jdbcType=INTEGER}, #{scenicId,jdbcType=INTEGER}, ",
            "#{hotelClass,jdbcType=CHAR}, #{hotelName,jdbcType=VARCHAR}, ",
            "#{hotelLink,jdbcType=VARCHAR}, #{hotelTel,jdbcType=VARCHAR}, ",
            "#{hotelAddress,jdbcType=VARCHAR}, #{hotelPic,jdbcType=VARCHAR}, ",
            "#{status,jdbcType=CHAR}, #{creatTime,jdbcType=TIMESTAMP})"
    })
    int insert(Hotel record);

    @InsertProvider(type = HotelSqlProvider.class, method = "insertSelective")
    int insertSelective(Hotel record);

    @Select({
            "select",
            "hotel_id, scenic_id, hotel_class, hotel_name, hotel_link, hotel_tel, hotel_address, ",
            "hotel_pic, status, creat_time",
            "from hotel",
            "where hotel_id = #{hotelId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "hotel_id", property = "hotelId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "scenic_id", property = "scenicId", jdbcType = JdbcType.INTEGER),
            @Result(column = "hotel_class", property = "hotelClass", jdbcType = JdbcType.CHAR),
            @Result(column = "hotel_name", property = "hotelName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "hotel_link", property = "hotelLink", jdbcType = JdbcType.VARCHAR),
            @Result(column = "hotel_tel", property = "hotelTel", jdbcType = JdbcType.VARCHAR),
            @Result(column = "hotel_address", property = "hotelAddress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "hotel_pic", property = "hotelPic", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.CHAR),
            @Result(column = "creat_time", property = "creatTime", jdbcType = JdbcType.TIMESTAMP)
    })
    Hotel selectByPrimaryKey(Integer hotelId);

    @UpdateProvider(type = HotelSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Hotel record);

    @Update({
            "update hotel",
            "set scenic_id = #{scenicId,jdbcType=INTEGER},",
            "hotel_class = #{hotelClass,jdbcType=CHAR},",
            "hotel_name = #{hotelName,jdbcType=VARCHAR},",
            "hotel_link = #{hotelLink,jdbcType=VARCHAR},",
            "hotel_tel = #{hotelTel,jdbcType=VARCHAR},",
            "hotel_address = #{hotelAddress,jdbcType=VARCHAR},",
            "hotel_pic = #{hotelPic,jdbcType=VARCHAR},",
            "status = #{status,jdbcType=CHAR},",
            "creat_time = #{creatTime,jdbcType=TIMESTAMP}",
            "where hotel_id = #{hotelId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Hotel record);
}