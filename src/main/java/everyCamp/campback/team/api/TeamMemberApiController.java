package everyCamp.campback.team.api;

import everyCamp.campback.team.dto.TeamMemberResponse;
import everyCamp.campback.team.service.ITeamMemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamMemberApiController extends TeamMemberBaseController{
    private final ITeamMemberService teamMemberService;
    @GetMapping("")
    public List<TeamMemberResponse> findAllMembers(@RequestParam("team_id") String teamId) {
        return teamMemberService.findAllMembers(teamId);
    }

    @PatchMapping("")
    public void dropMember(@RequestParam("team_id") String teamId, @RequestBody DropMemberDto dropMemberDto){
        // TODO: 팀장 권한 검사 추가
        teamMemberService.dropMember(teamId, dropMemberDto.getUserId());
    }

    @Getter
    static class DropMemberDto{
        private String userId;
    }

    @DeleteMapping("/withdraw")
    public void updateTeamMember(@RequestParam("team_id") String teamId) {
        // TODO: userId
        String userId = "";
        teamMemberService.updateMember(teamId, userId);
    }
}
