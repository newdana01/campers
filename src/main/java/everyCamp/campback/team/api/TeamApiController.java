package everyCamp.campback.team.api;

import everyCamp.campback.team.service.ITeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeamApiController extends TeamBaseController{
    private final ITeamService teamService;

}
