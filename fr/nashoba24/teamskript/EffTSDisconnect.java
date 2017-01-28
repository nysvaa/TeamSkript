package fr.nashoba24.teamskript;

import javax.annotation.Nullable;

import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

public class EffTSDisconnect extends Effect {
	
	@Override
	public boolean init(Expression<?>[] expr, int matchedPattern, Kleenean paramKleenean, ParseResult paramParseResult) {
		return true;
	}
	
	@Override
	public String toString(@Nullable Event e, boolean b) {
		return "ts3 disconnect";
	}
	
	@Override
	protected void execute(Event e) {
		if(TeamSkript.ts3api != null) {
			TeamSkript.ts3api.logout();
			TeamSkript.ts3api = null;
		}
		if(TeamSkript.ts3query != null) {
			TeamSkript.ts3query.exit();
			TeamSkript.ts3query = null;
		}
	}
}
