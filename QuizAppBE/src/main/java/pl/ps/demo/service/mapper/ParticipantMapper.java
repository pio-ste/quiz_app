package pl.ps.demo.service.mapper;

import pl.ps.demo.model.entity.Participant;
import pl.ps.demo.service.dto.ParticipantDTO;

public class ParticipantMapper {

    public ParticipantMapper() {
    }

    public static ParticipantDTO mapFromEntityToDto(Participant participant) {
        return ParticipantDTO.builder()
                .id(participant.getId())
                .result(participant.getResult())
                .status(participant.getStatus())
                .build();
    }

    public static Participant mapFromDtoToEntity(ParticipantDTO participantDTO){
        return Participant.builder()
                .id(participantDTO.getId())
                .result(participantDTO.getResult())
                .status(participantDTO.getStatus())
                .build();
    }
}
