package com.example.tptiendamobile.adapter


class GalleryAdapter() {



}
//
//class GalleryAdapter(private val context: Context, private val imageList: List<Imagen>) : PagerAdapter() {
//
//
//    override fun isViewFromObject(view: View, `object`: Any): Boolean {
//        return view == `object`
//    }
//
//    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        val view = LayoutInflater.from(context).inflate(R.layout.viewpager_item_gallery, null)
//        val imageView = view.findViewById<SimpleDraweeView>(R.id.imageGallery)
//        imageView.setImageURI(getImageAt(position))
//        container.addView(view)
//        return view
//    }
//
//    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
//        container.removeView(view as View)
//    }
//
//    override fun getCount(): Int = imageList.size
//
//
//    private fun getImageAt(position: Int): String? {
//        imageList.let {
//            return it.get(position).url
//        }
//    }
//}