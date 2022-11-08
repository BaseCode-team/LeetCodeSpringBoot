package study.team.leetcode.problem.excutor;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.exception.BizException;
import org.springframework.stereotype.Component;
import study.team.leetcode.dto.ProblemAddCmd;
import study.team.leetcode.dto.data.ExceptionCodeEnum;

/**
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-08 19:35
 * @description 力扣问题添加执行器
 */
@Component
public class ProblemAddCmdExe {
    public Response execute(ProblemAddCmd cmd) {
        //The flow of usecase is defined here.
        //The core ablility should be implemented in Domain. or sink to Domian gradually
        if ("test".equals(cmd.getLeetCodeProblemDTO().getName())) {
            throw new BizException(ExceptionCodeEnum.BODY_NOT_MATCH.getErrCode(), "公司名冲突");
        }
        return Response.buildSuccess();
    }
}
