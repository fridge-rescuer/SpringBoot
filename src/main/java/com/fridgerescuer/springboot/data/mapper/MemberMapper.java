package com.fridgerescuer.springboot.data.mapper;

import com.fridgerescuer.springboot.data.dto.MemberDTO;
import com.fridgerescuer.springboot.data.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper( uses = {RecipeMapper.class, ExpirationDataMapper.class})
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    @Mapping(source = "expirationDataList", target = "expirationDataDTOList")
    @Mapping(source = "privateExpirationDataList", target = "privateExpirationDataDTOList")
    @Mapping(source = "recipes", target = "recipeDTOs")
    MemberDTO memberToDto(Member member);


    @Mapping(source = "expirationDataDTOList", target = "expirationDataList")
    @Mapping(source = "privateExpirationDataDTOList", target = "privateExpirationDataList")
    @Mapping(source = "recipeDTOs", target = "recipes")
    Member DtoToMember(MemberDTO memberDto);

}