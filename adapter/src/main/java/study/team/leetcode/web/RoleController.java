package study.team.leetcode.web;

import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色控制器
 *
 * @author JiaHao
 * @date 2022-12-11 15:37
 */
@Api(tags = "角色模块")
@ApiSupport(author = "JiaHao")
@RestController
@Validated
public class RoleController {
}
