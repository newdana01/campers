package everyCamp.campback.team.api;

import everyCamp.campback.team.service.ITeamApplierService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeamApplierApiController extends TeamMemberBaseController{
    private final ITeamApplierService teamApplierService;

    @PostMapping("/{user_id}")
    public void approveMember(@PathVariable("user_id") String userId, @RequestBody ApproveMemberDto approveMemberDto) {
        //TODO: 권한 검사 추가
        teamApplierService.approveMember(
                approveMemberDto.getTeamId(),
                userId,
                approveMemberDto.getApproveOrDeny()
        );
    }

    @Getter
    static class ApproveMemberDto{
        private String teamId;
        private Boolean approveOrDeny;
    }

}
