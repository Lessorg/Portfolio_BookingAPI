package portfolio.project.bookingapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import portfolio.project.bookingapp.config.MapperConfig;
import portfolio.project.bookingapp.dto.accommodationdtos.AccommodationRequestDto;
import portfolio.project.bookingapp.dto.accommodationdtos.AccommodationResponseDto;
import portfolio.project.bookingapp.model.accommodation.Accommodation;

@Mapper(config = MapperConfig.class)
public interface AccommodationMapper {

    @Mapping(target = "id", ignore = true)
    Accommodation toEntity(AccommodationRequestDto request);

    AccommodationResponseDto toDto(Accommodation accommodation);

    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Accommodation accommodation, AccommodationRequestDto request);
}
