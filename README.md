O RecyclerView é uma nova view que veio para substituir o ListView e o GridView.

De acordo com sua documentação, trata-se de um widget mais avançado e eficiente, que apresenta diversas simplificações para suportar animações e diferentes disposições de elementos.

Para oferecer todas estas otimizações, a Google decidiu simplificar o elemento. Pode parecer estranho, mas o RecyclerView possui um nível de responsabilidade menor quando comparado ao ListView. Em teoria, o widget é apenas um container que encapsula um LayoutManager e um ItemAnimator, e que se comunica com um Adapter, mais precisamente, um RecyclerView.Adapter.
