package everyCamp.campback.team.api;

import com.google.gson.JsonObject;
import everyCamp.campback.team.dto.TeamCreateDto;
import everyCamp.campback.team.dto.TeamResponse;
import everyCamp.campback.team.service.ITeamService;
import everyCamp.campback.user.entity.User;
import everyCamp.campback.user.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamApiController extends TeamBaseController{
    private final ITeamService teamService;
    @PostMapping("")
    public String createTeam(@RequestBody TeamCreateDto teamCreateDto) {
        JsonObject res = new JsonObject();
        String teamId = teamService.createTeam(teamCreateDto);
        res.addProperty("teamId", teamId);
        return res.toString();
    }
}
