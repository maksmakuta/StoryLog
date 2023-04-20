package ua.makuta.storylog.core


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class CoreAdapter<M : Any,VB : ViewBinding> : RecyclerView.Adapter<CoreAdapter<M,VB>.CoreHolder<VB>>(), MutableList<M> {

    private val data = ArrayList<M>()

    abstract fun onCreate(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ) : VB

    abstract fun onBind(binding: VB,item : M)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoreHolder<VB> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = onCreate(inflater,parent,viewType)
        return CoreHolder(binding)
    }

    override fun onBindViewHolder(holder: CoreHolder<VB>, position: Int) {
        onBind(holder.viewBinding,this[position])
    }

    override fun getItemCount(): Int = size

    fun toArray() = data

    override val size: Int
        get() = data.size

    override fun get(index: Int): M = data[index]
    override fun isEmpty(): Boolean = data.isEmpty()
    override fun clear(){
        val i = size
        data.clear()
        notifyItemRangeRemoved(0,i)
    }
    override fun addAll(elements: Collection<M>): Boolean{
        val b = size
        val s = data.addAll(elements)
        notifyItemRangeInserted(b,elements.size)
        return s
    }
    override fun addAll(index: Int, elements: Collection<M>): Boolean{
        val b = size
        val s = data.addAll(index, elements)
        notifyItemRangeInserted(b,elements.size)
        return s

    }
    override fun add(index: Int, element: M){
        data.add(index, element)
        notifyItemInserted(index)
    }
    override fun add(element: M): Boolean{
        val i = size
        val s = data.add(element)
        notifyItemInserted(i+1)
        return s
    }
    override fun iterator(): MutableIterator<M> = data.iterator()
    override fun listIterator(): MutableListIterator<M> = data.listIterator()
    override fun listIterator(index: Int): MutableListIterator<M> = data.listIterator(index)
    override fun removeAt(index: Int): M{
        val i = data.removeAt(index)
        notifyItemRemoved(index)
        return i
    }
    override fun subList(fromIndex: Int, toIndex: Int): MutableList<M> = data.subList(fromIndex,toIndex)
    override fun set(index: Int, element: M): M{
        val i = data.set(index,element)
        notifyItemChanged(index)
        return i
    }
    override fun retainAll(elements: Collection<M>): Boolean{
        val arr = ArrayList<Int>()
        for(item in elements){
            val i = data.indexOf(item)
            if(i != -1)
                arr.add(i)
        }
        val s = data.retainAll(elements.toSet())
        for(item in arr){
            notifyItemRemoved(item)
        }
        return s
    }
    override fun removeAll(elements: Collection<M>): Boolean{
        val arr = ArrayList<Int>()
        for(item in elements){
            val i = data.indexOf(item)
            if(i != -1)
                arr.add(i)
        }
        val s = data.removeAll(elements.toSet())
        for(item in arr){
            notifyItemRemoved(item)
        }
        return s
    }
    override fun remove(element: M): Boolean{
        val i = indexOf(element)
        val s = data.remove(element)
        if(i != -1)
            notifyItemRemoved(i)
        return s
    }
    override fun lastIndexOf(element: M): Int = data.lastIndexOf(element)
    override fun indexOf(element: M): Int = data.indexOf(element)
    override fun containsAll(elements: Collection<M>): Boolean = data.containsAll(elements)
    override fun contains(element: M): Boolean = data.contains(element)

    inner class CoreHolder<VB : ViewBinding>(
        val viewBinding: VB
    ) : RecyclerView.ViewHolder(viewBinding.root)
}