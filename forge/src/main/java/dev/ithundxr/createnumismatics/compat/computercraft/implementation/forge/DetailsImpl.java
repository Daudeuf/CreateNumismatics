/*
 * Numismatics
 * Copyright (c) 2024 The Railways Team
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package dev.ithundxr.createnumismatics.compat.computercraft.implementation.forge;

import dan200.computercraft.api.detail.ForgeDetailRegistries;
import dan200.computercraft.api.detail.VanillaDetailRegistries;
import dev.ithundxr.createnumismatics.multiloader.fluid.MultiloaderFluidStack;
import dev.ithundxr.createnumismatics.multiloader.fluid.forge.MultiloaderFluidStackImpl;
import net.minecraft.world.item.ItemStack;

import java.util.Map;

public class DetailsImpl {
    public static Map<String, Object> getItemDetail(ItemStack stack) {
        return VanillaDetailRegistries.ITEM_STACK.getDetails(stack);
    }

    public static Map<String, Object> getFluidDetail(MultiloaderFluidStack stack) {
        return ForgeDetailRegistries.FLUID_STACK.getDetails(((MultiloaderFluidStackImpl) stack).getWrapped());
    }
}
