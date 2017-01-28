package fr.nashoba24.teamskript;

import javax.annotation.Nullable;

import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

public class EffTSSendChannelMessage extends Effect {
	
	private Expression<String> msg;
	private Expression<Integer> id;
	private boolean set = false;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] expr, int matchedPattern, Kleenean paramKleenean, ParseResult paramParseResult) {
		msg = (Expression<String>) expr[0];
		if(expr.length==2) {
			id = (Expression<Integer>) expr[1];
		}
		return true;
	}
	
	@Override
	public String toString(@Nullable Event e, boolean b) {
		return "ts3 send channel message";
	}
	
	@Override
	protected void execute(Event e) {
		if(TeamSkript.ts3api != null) {
			if(TeamSkript.ts3api.whoAmI().getVirtualServerId()==id.getSingle(e) || set) {
				TeamSkript.ts3api.sendChannelMessage(msg.getSingle(e));
			}
			else {
				TeamSkript.ts3api.sendChannelMessage(id.getSingle(e), msg.getSingle(e));
			}
		}
	}
}
