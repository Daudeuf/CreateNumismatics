package dev.ithundxr.createnumismatics.content.depositor;

import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.blockEntity.behaviour.scrollValue.ScrollOptionBehaviour;
import com.simibubi.create.foundation.utility.Components;
import com.simibubi.create.foundation.utility.Lang;
import dev.ithundxr.createnumismatics.content.backend.Coin;
import dev.ithundxr.createnumismatics.registry.NumismaticsMenuTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AndesiteDepositorBlockEntity extends AbstractDepositorBlockEntity implements MenuProvider {

    private ScrollOptionBehaviour<Coin> coinOption;

    public AndesiteDepositorBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        coinOption = new ProtectedScrollOptionBehaviour<>(Coin.class, Components.translatable("create.numismatics.andesite_depositor.price"), this,
            new DepositorValueBoxTransform(), this::isTrusted);
        behaviours.add(coinOption);
    }

    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        Coin coin = coinOption.get();
        Lang.builder()
            .add(Components.translatable("block.numismatics.andesite_depositor.tooltip.price",
                    1, Components.translatable(coin.getTranslationKey()), coin.value
                ).withStyle(coin.rarity.color)
            )
            .forGoggles(tooltip);
        return true;
    }

    public Coin getCoin() {
        return coinOption.get();
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Components.translatable("block.numismatics.andesite_depositor");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new AndesiteDepositorMenu(NumismaticsMenuTypes.ANDESITE_DEPOSITOR.get(), i, inventory, this);
    }
}
