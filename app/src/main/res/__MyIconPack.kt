import androidx.compose.ui.graphics.vector.ImageVector
import myiconpack.Illustration
import myiconpack.`Illustration copy`
import myiconpack.`Illustration copy 2`
import kotlin.collections.List as ____KtList

public object MyIconPack

private var __ic_: ____KtList<ImageVector>? = null

public val MyIconPack.ic_: ____KtList<ImageVector>
  get() {
    if (__ic_ != null) {
      return __ic_!!
    }
    __ic_= listOf(Illustration, `Illustration copy`, `Illustration copy 2`)
    return __ic_!!
  }
