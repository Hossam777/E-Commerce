package com.project.ecommerce.shopfragment.data

val shopLists: MutableList<MutableList<ListItem>>
        get() = arrayListOf(
                womenList,
                menList,
                kidsList
        )

private val womenList: MutableList<ListItem> = arrayListOf(
        ListItem(
                "W1",
                "New",
                "https://www.maridfashion.com/wp-content/uploads/2020/06/IMG_8079-min.jpg",
        ),
        ListItem(
                "W2",
        "Clothes",
        "https://i.pinimg.com/736x/20/24/65/20246528ff0dc2ee8d11f675ded62e2d.jpg",
        ),
        ListItem(
                "W3",
        "Shoes",
        "https://i.pinimg.com/originals/e1/3c/e8/e13ce8c0004d16ca35ccd37e279333c2.jpg",
        ),
        ListItem(
                "W4",
        "Accessories",
        "https://n3.sdlcdn.com/imgs/j/q/p/Darshini-Designs-pearl-necklace-set-SDL862131040-1-c6bf1.jpeg",
        ),
)
private val menList: MutableList<ListItem> = arrayListOf(
        ListItem(
                "M1",
                "New",
                "https://i.pinimg.com/originals/40/e1/d0/40e1d0e48f2e43aab32ebde996a3837e.jpg",
        ),
        ListItem(
                "M2",
                "Clothes",
                "https://manofmany.com/wp-content/uploads/2017/11/Guide-mens-smart-casual-dress-code4.jpg",
        ),
        ListItem(
                "M3",
                "Shoes",
                "https://i.pinimg.com/236x/be/e6/6c/bee66cea17c3627b7a283bda168a520a--mens-casual-shoes-men-casual.jpg",
        ),
        ListItem(
                "M4",
                "Accessories",
                "https://ae01.alicdn.com/kf/HTB1ZvyEOhnaK1RjSZFBq6AW7VXa8/Stone-Beads-Bracelet-Men-Accessories-Crown-Braclets-Handmade-2-Piece-Set-Erkek-Bileklik-Skull-Jewelry-Mens.jpg_Q90.jpg",
        ),
)
private val kidsList: MutableList<ListItem> = arrayListOf(
        ListItem(
                "K1",
                "New",
                "https://i.pinimg.com/564x/ea/f4/5f/eaf45f252f7e3e70971605ee3d8cea91.jpg",
        ),
        ListItem(
                "K2",
                "Clothes",
                "https://ae01.alicdn.com/kf/Hc439c5ca633d46be94e2c2aea52c25a1z/Girls-Summer-Clothes-Suit-2020-New-Casual-Clothes-For-Kids-Outfits-4-6-8-10-12.jpg",
        ),
        ListItem(
                "K3",
                "Shoes",
                "https://img.joomcdn.net/566ddf03fa67df0e6252041f0c7d40dfb7084f76_original.jpeg",
        ),
        ListItem(
                "K4",
                "Accessories",
                "https://mi0.rightinthebox.com/images/384x384/201705/fqgvsg1494233433386.jpg",
        ),
)