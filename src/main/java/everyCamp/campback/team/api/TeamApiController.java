package everyCamp.campback.team.api;

import com.google.gson.JsonObject;
import everyCamp.campback.team.dto.TeamCreateDto;
import everyCamp.campback.team.dto.TeamResponse;
import everyCamp.campback.team.dto.TeamUpdateDto;
import everyCamp.campback.team.service.ITeamService;
import everyCamp.campback.user.entity.User;
import everyCamp.campback.user.repository.IUserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamApiController extends TeamBaseController{
    private final ITeamService teamService;

    @PatchMapping("/{team_id}/leader")
    public String assignLeader(@PathVariable("team_id") String teamId, @RequestBody TeamLeaderDto assignLeaderDto) {
        // TODO: 토큰에서 유저 아이디 전달받아 권한 검사 추가
        teamService.assignLeader(teamId, assignLeaderDto.getFrom(), assignLeaderDto.getTo());
        JsonObject res = new JsonObject();
        res.addProperty("teamId", teamId);
        return res.toString();
    }

    @Getter
    class TeamLeaderDto{
        private String from;
        private String to;
    }

    @PatchMapping("/{team_id}")
    public String updateTeam(@PathVariable("team_id") String teamId, @RequestBody TeamUpdateDto updateDto) {
        JsonObject res = new JsonObject();
        teamService.updateTeam(teamId, updateDto);
        res.addProperty("teamId", teamId);
        return res.toString();
    }

    @PostMapping("")
    public String createTeam(@RequestBody TeamCreateDto teamCreateDto) {
        JsonObject res = new JsonObject();
        String teamId = teamService.createTeam(teamCreateDto);
        res.addProperty("teamId", teamId);
        return res.toString();
    }

    @GetMapping("/{team_id}")
    public TeamResponse findTeam(@PathVariable("team_id") String teamId) {
        TeamResponse team = teamService.findTeam(teamId);
        return team;
    }
}
