package com.namdroid.namserverspring.mapper;

import com.namdroid.namserverspring.model.UserProfile;
import org.apache.ibatis.annotations.*;

@Mapper // 서비스 로직과 db사이의 인터페이스 역할을 함
public interface IUserProfileMapper {

    @Select("SELECT * " +
            " FROM UserProfile " +
            "WHERE id=#{id}")
    UserProfile getUserProfileById(@Param("id") String id);

    @Insert("INSERT INTO UserProfile " +
            "VALUES(#{id}, #{name}, #{phone}, #{address}, #{valid}")
    int insertUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("address") String address , @Param("valid") String valid);

    @Update("UPDATE UserProfile " +
            "  SET name = #{name}, phone = #{phone}, address = #{address} " +
            "WHERE id = #{id}")
    int updateUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("address") String address);

    @Update("UPDATE UserProfile " +
            "  SET valid = #{valid}" +
            "WHERE id = #{id}")
    int updateUserProfileValid(@Param("id") String id, @Param("valid") String valid);
}
