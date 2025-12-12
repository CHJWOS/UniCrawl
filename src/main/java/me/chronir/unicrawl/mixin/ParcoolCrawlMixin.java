package me.chronir.unicrawl.mixin;

import com.alrex.parcool.common.action.impl.Crawl;
import com.tacz.guns.api.client.gameplay.IClientPlayerGunOperator;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Crawl.class, remap = false)
public class ParcoolCrawlMixin {

    @Shadow
    public boolean toggleStatus;

    @Inject(method = "onWorkingTickInClient", at = @At("TAIL"))
    private void onWorkingTickInClient(CallbackInfo ci) {
        IClientPlayerGunOperator.fromLocalPlayer(Minecraft.getInstance().player).crawl(toggleStatus);
    }

}
