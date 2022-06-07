package eu.dateio.service;

import eu.dateio.dao.UserBehaviourRepository;
import eu.dateio.dto.UserBehaviourDto;
import eu.dateio.exceptions.InvalidDtoException;
import eu.dateio.model.Client;
import eu.dateio.model.Offer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(
        MockitoExtension.class
)
class UserBehaviourServiceTest {
    @InjectMocks
    UserBehaviourService service;
    @Mock
    UserBehaviourRepository dao;
    @Mock
    ClientService clientService;
    @Mock
    OfferService offerService;

    @Test
    public void test_dto_invalid(){
        //  arrange
        UserBehaviourDto dto = new UserBehaviourDto();
        dto.setClientId(2);

        // act, verify
        assertThrows(InvalidDtoException.class, () -> service.processDto(dto));
    }

    @Test
    public void test_dto_valid(){
        //  arrange
        UserBehaviourDto dto = new UserBehaviourDto();
        dto.setClientId(2);
        dto.setOfferId(2);
        dto.setIsOfferActive(true);
        dto.setIsOfferSeen(true);
        dto.setLastSeen(OffsetDateTime.now());

        Mockito.when(clientService.findClientById(2)).thenReturn(new Client());
        Mockito.when(offerService.findOfferById(2)).thenReturn(new Offer());

        // act
        service.processDto(dto);

        // verify
        Mockito.verify(dao, Mockito.times(1)).save(Mockito.any());
    }
}