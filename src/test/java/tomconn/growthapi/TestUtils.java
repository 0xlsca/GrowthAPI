package tomconn.growthapi;

import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

public class TestUtils {

    public final static Objenesis OBJENESIS = new ObjenesisStd();

    static {
        WORLD = OBJENESIS.getInstantiatorOf(WorldClient.class).newInstance();
        BLOCK = OBJENESIS.getInstantiatorOf(Block.class).newInstance();
        BLOCK_STATE = OBJENESIS.getInstantiatorOf(BlockStateContainer.StateImplementation.class).newInstance();
        BLOCK_POS = new BlockPos(0, 0, 0);
    }


    public final static Block BLOCK;
    public final static World WORLD;
    public final static IBlockState BLOCK_STATE;
    public final static BlockPos BLOCK_POS;

}
