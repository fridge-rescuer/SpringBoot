package com.fridgerescuer.springboot.data.mapper;

import com.fridgerescuer.springboot.data.dto.MemberDTO;
import com.fridgerescuer.springboot.data.dto.MemberResponseDTO;
import com.fridgerescuer.springboot.data.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    MemberDTO memberToDto(Member member);

    Member DtoToMember(MemberDTO memberDto);

    @Mapping(source = "ingredients", target = "ingredientResponseDTOs")
    @Mapping(source = "recipes", target = "recipeResponseDTOs")
    MemberResponseDTO memberToResponseDto(Member member);
}
