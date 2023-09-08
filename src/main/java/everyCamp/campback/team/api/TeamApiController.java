package everyCamp.campback.team.api;

import everyCamp.campback.team.service.ITeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class TeamApiController {
    private final ITeamService teamService;


}
