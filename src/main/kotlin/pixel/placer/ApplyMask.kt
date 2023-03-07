package pixel.placer

import config.schema.Config

object ApplyMask : Placer {
    override fun place(image: Array<IntArray>, mask: Array<BooleanArray>, ifTrue: Config.Tile, ifFalse: Config.Tile): Array<IntArray> {
        for (y in mask.indices) {
            for (x in mask[0].indices) {
                val shouldApply = mask[y][x]
                image[y][x] = if (shouldApply) ifTrue.colour else ifFalse.colour
            }
        }
        return image
    }
}