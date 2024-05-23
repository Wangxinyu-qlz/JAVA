package web.datavalid;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-28 16:21
 * @description:
 **/
@Controller()
@Scope(value = "prototype")
public class MonsterHandler {
	@RequestMapping(value = "/addMonsterUI")
	public String addMonsterUI(Map<String, Object> map) {
		map.put("monster", new Monster());

		return "data_valid/monster_addUI";
	}

	/**
	 * @Valid Monster monster表示对 monster 接收的数据进行校验
	 * Errors errors 表示，如果校验出现错误，将错误信息保存在 errors
	 * Map<String, Object> map 表示，如果校验出现错误，将错误信息保存在 map，同时保存接收到的 monster 对象
	 * @param monster
	 * @param errors
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/save")
	//添加妖怪
	public String saveMonster(@Valid Monster monster, Errors errors, Map<String, Object> map) {
		System.out.println("monster = " + monster);
		System.out.println("=========map==============");
		for(Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
		}
		System.out.println("==========errors==============");
		if (errors.hasErrors()) {
			List<ObjectError> errorsList = errors.getAllErrors();
			for (ObjectError error : errorsList) {
				System.out.println("error = " + error);
			}

			return "data_valid/monster_addUI";
		}
		return "data_valid/success";
	}

	//取消绑定 monster 的 name 表单提交的值给 monster.name属性
	//不希望接收到某个表单对应的属性
	@InitBinder()
	public void initBinder(WebDataBinder webDataBinder) {
		//方法上做注解：@InitBinder()
		//底层是反射机制
		//TODO 取消某个属性的绑定，需要将验证的注解去掉
		//@NotEmpty
		//private String name = "user";

		//解决输入中文乱码问题需要回复绑定
		//webDataBinder.setDisallowedFields("name");
	}
}
