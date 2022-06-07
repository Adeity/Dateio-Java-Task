package eu.dateio.rest;

import eu.dateio.dto.UserBehaviourDto;
import eu.dateio.service.UserBehaviourService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/userBehaviour")
public class UserBehaviourController {
    private final UserBehaviourService service;

    public UserBehaviourController(UserBehaviourService service) {
        this.service = service;
    }

    /**
     * CREATE UserBehaviour entry
     * @param dto - UserBehaviourDto sent from bank
     */
    @PostMapping(consumes = (MediaType.APPLICATION_JSON_VALUE))
    public void postUserBehaviour(@RequestBody UserBehaviourDto dto){
        service.processDto(dto);
    }
}
